package self.samson.ssm.learn.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        return new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }

    // Temporary location where files will be stored
    private static final String LOCATION = "E:/00-Workspace/tmp";
    // 5MB : Max file size.
    // Beyond that size spring will throw exception.
    private static final long MAX_FILE_SIZE = 5242880;
    // 20MB : Total request size containing Multi part.
    private static final long MAX_REQUEST_SIZE = 20971520;
    // Size threshold after which files will be written to disk
    private static final int FILE_SIZE_THRESHOLD = 0;
}
