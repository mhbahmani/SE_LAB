package resource_loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ResourceLoader {
    private final String resourceName;

    public ResourceLoader(String resourceName) {
        this.resourceName = resourceName;
    }

    public InputStream getAsInputStream() {
        return Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(this.resourceName));
    }

    public List<String> getContent() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(Objects.requireNonNull(
                getClass().getClassLoader().getResource(this.resourceName)).toURI()));


    }
}
