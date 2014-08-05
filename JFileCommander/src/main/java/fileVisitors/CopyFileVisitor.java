package fileVisitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileVisitor extends SimpleFileVisitor<Path> {
	private Path fromPath;
    private Path toPath;
    public CopyFileVisitor(Path fromPath, Path toPath) {
        this.fromPath = fromPath;
        this.toPath = toPath;
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir,
    final BasicFileAttributes attrs) throws IOException {
        Path targetPath = toPath.resolve(fromPath.relativize(dir));
        if(!Files.exists(targetPath))
        	Files.copy(dir, targetPath);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, toPath.resolve(fromPath.relativize(file)));
        return FileVisitResult.CONTINUE;
    }
}