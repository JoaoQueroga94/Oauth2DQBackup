package itriad.com.services;

// import io.github.swagger2markup.Swagger2MarkupConverter;
import itriad.com.Application;
import itriad.com.SwaggerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {Application.class, SwaggerConfig.class})
//@WebAppConfiguration
//public class Swagger2MarkupTest {
//
//    @Test
//    public void convertRemoteSwaggerToAsciiDoc() throws MalformedURLException {
//        // Remote Swagger source
//        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs")).build()
//                .toFolder(Paths.get("build/asciidoc"));
//    }
//}