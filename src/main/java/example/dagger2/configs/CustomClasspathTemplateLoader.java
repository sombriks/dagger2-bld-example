package example.dagger2.configs;

import de.neuland.pug4j.template.TemplateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class CustomClasspathTemplateLoader implements TemplateLoader {

    @Override
    public long getLastModified(String s) throws IOException {
        return -1L;
    }

    @Override
    public Reader getReader(String s) throws IOException {
        String path = s.startsWith("/") ? s.substring(1) : s;
        if (!path.startsWith("templates/")) {
            path = "/templates/" + path;
        }

        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            path = "/resources" + path;
            stream = getClass().getResourceAsStream(path);
        }
        if (stream == null) {
            throw new IOException("Template not found in classpath: " + path);
        }
        return new InputStreamReader(stream);
    }

    @Override
    public String getExtension() {
        return "pug";
    }

    @Override
    public String getBase() {
        return "";
    }
}
