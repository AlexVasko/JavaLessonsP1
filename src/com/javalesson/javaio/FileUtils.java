package com.javalesson.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {


    public void printIOFileDetails(String path) throws IOException {
        File file = new File(path);

//        Get path details
        System.out.println("Absolute path " + file.getAbsolutePath());
        System.out.println("Relative path " + file.getPath());
        System.out.println("Free space in MBytes " + file.getFreeSpace() / 1000000);
        System.out.println("Parent directory " + file.getParent());
        System.out.println("Is absolute path " + file.isAbsolute());

        System.out.println("Current directory is : " + System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is a directory. Printing content:");
            String[] list = file.list();
            if (list != null) {
                for (String el : list)
                    System.out.println(el);
            }
        } else {
            System.out.println("It is a file ");
            System.out.println("Creating a new file " + file.createNewFile());
            //        Permissions
            System.out.println("Can read - " + file.canRead());
            System.out.println("Can write - " + file.canWrite());
            System.out.println("Can execute - " + file.canExecute());
            System.out.println("File is hidden - " + file.isHidden());
            System.out.println("Last modified - " + file.lastModified());
            System.out.println("Deleting a file " + file.delete());

            Path filePath = file.toPath();


        }
    }


    public void printNioFileDetails(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);
        Path path2 = Paths.get(System.getProperty("user.dir"), fileName);

        System.out.println("File name " + path.getFileName());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Root dir " + absolutePath.getRoot());
        System.out.println("Absolute path" + absolutePath);
        System.out.println("Parent dir " + absolutePath.getParent());
        System.out.println("Name count " + absolutePath.getNameCount());
        System.out.println("Sub-path " + absolutePath.subpath(0, 3));
        Path path3 = Paths.get("../../");
        System.out.println("Real path " + path3.toRealPath());

        System.out.println("File exists " + Files.exists(path));
        System.out.println("File does not exist " + Files.notExists(path));
        System.out.println("Is readable " + Files.isReadable(path));
        System.out.println("Is writable " + Files.isWritable(path));
        System.out.println("Is executable " + Files.isExecutable(path));

        System.out.println("Is the same file " + Files.isSameFile(path, path1));

        Path parentPath = absolutePath.getParent();
        Path filesPath = parentPath.resolve("files");
        if (Files.notExists(filesPath)) {
            Files.createDirectory(filesPath);
        }
        Files.move(absolutePath, filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(filesPath.resolve(path));
        Files.delete(filesPath);

    }


    public void processDir() throws IOException {
        Path dir = Paths.get("temp");
        if (Files.notExists(dir)) {
            Files.createDirectory(dir);
        }

        Files.createDirectories(Paths.get("temp/a/b/c"));

//        Files.createTempDirectory(dir, "tmp");

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for(Path rootDir : rootDirectories){
            System.out.println(rootDir);
        }


        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        try(DirectoryStream<Path> paths = Files.newDirectoryStream(dir, filter)){
            for (Path p : paths){
                System.out.println(p);
            }
        }

    }


}
