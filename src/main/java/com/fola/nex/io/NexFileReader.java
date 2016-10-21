package com.fola.nex.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NexFileReader {

	public List<String> readLinesFromFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		try (Stream<String> lines = Files.lines(path)) {
			return lines.map(arg -> arg.trim())
					    .collect(Collectors.toList());
		}
	}

}
