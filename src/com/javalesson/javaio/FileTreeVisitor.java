package com.javalesson.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FileTreeVisitor {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("temp");
//        Files.walkFileTree(path, new Visitor());
        Files.walkFileTree(path, new CopyFileVisitor(path, Paths.get("temp2"+File.separator+"copy")));

    }

    public static class Visitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            renameFile(file);
            return FileVisitResult.CONTINUE;
        }

        private void renameFile(Path file) throws IOException {
            int nameCount = file.getNameCount();
            if (nameCount > 1) {
                Path start = file.subpath(0, nameCount - 1);
                Path end = file.subpath(nameCount - 1, nameCount);
                Files.move(file, Paths.get(start + File.separator + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + "__" + end));
            }
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println(dir);

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            renameFile(dir);
            return FileVisitResult.CONTINUE;
        }
    }

    public static class CopyFileVisitor extends SimpleFileVisitor<Path> {


        Path source;
        Path destination;

        public CopyFileVisitor(Path source, Path destination) {
            this.source = source;
            this.destination = destination;
        }


        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
            try{
            copy(path);
            } catch (IOException e){
                System.err.println("Copy directory error "+path);
                e.printStackTrace();
                return FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        private void copy(Path path) throws IOException {
            Path relative = source.relativize(path);
            System.out.println("Relative path "+relative);
            Path destinationPath = destination.resolve(relative);
            System.out.println("Destination path "+destinationPath);
            Files.copy(path, destinationPath);
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            try{
                copy(path);
            } catch (IOException e){
                System.err.println("Copy file error "+path);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Copy file failed " + file);
            return FileVisitResult.CONTINUE;
        }
    }
}
