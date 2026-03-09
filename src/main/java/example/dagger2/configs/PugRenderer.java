package example.dagger2.configs;

import de.neuland.pug4j.PugConfiguration;
import de.neuland.pug4j.template.ClasspathTemplateLoader;
import de.neuland.pug4j.template.PugTemplate;
import io.javalin.http.Context;
import io.javalin.rendering.FileRenderer;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Map;

public class PugRenderer implements FileRenderer {

    private static final Logger LOG = LoggerFactory.getLogger(PugRenderer.class);

    PugConfiguration config = new PugConfiguration();

    @Inject
    public PugRenderer() {
        LOG.info("PugRenderer is instantiated");
        config.setTemplateLoader(new ClasspathTemplateLoader("templates"));
        // TODO make it configurable
        config.setCaching(false);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String render(String filePath, Map<String, ?> model, Context context) {
        try {
            PugTemplate template = config.getTemplate(filePath);
            StringWriter writer = new StringWriter();
            config.renderTemplate(template, (Map<String, Object>) model, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to render pug template: " + filePath, e);
        }
    }
}
