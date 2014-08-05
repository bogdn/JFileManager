package fileVisitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {

		System.out.println("Deleting file: " + file);
		Files.delete(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {

		System.out.println("Deleting dir: " + dir);
		if (exc == null) {
			Files.delete(dir);
			return FileVisitResult.CONTINUE;
		} else {
			throw exc;
		}
	}
}
