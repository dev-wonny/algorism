package main._202501._30;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesTest {
    private static final int FILE_SIZE = 200 * 1024 * 1024; // 200MB

    public static void main(String[] args) throws IOException {

        // 디렉토리 생성
        Path dirPath = Path.of("temp");
        try {
            Files.createDirectory(dirPath);
        } catch (IOException e) {
            System.out.println(dirPath + "Directory already exist");
        }


        // 새 파일 생성
        Path filePath = Path.of("temp/test.txt");
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println(filePath + "File already exist");
        }
        System.out.println("Absolute path = " + filePath.toAbsolutePath());
        System.out.println("Canonical path = " + filePath.toRealPath());


        // 파일 쓰기

        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);


        // 파일에 쓰기
        Files.writeString(filePath, writeString, UTF_8);
        // 파일에서 읽기
        String readString = Files.readString(filePath, UTF_8);

        System.out.println("== Read String ==");
        System.out.println(readString);

        //isFile?
        System.out.println(Files.isRegularFile(filePath));
        System.out.println(Files.isRegularFile(dirPath));

        //isDiretory?
        System.out.println(Files.isDirectory(filePath));
        System.out.println(Files.isDirectory(dirPath));

        // getName
        System.out.println(filePath.getFileName());
        System.out.println(dirPath.getFileName());

        // getSize
        System.out.println("size: " + Files.size(filePath));
        System.out.println("size: " + Files.size(dirPath));

        // 파일 복사
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/test.txt");
        Path target = Path.of("temp/test_new.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

    }
}
