package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.StreamedFile;

import static io.micronaut.http.MediaType.TEXT_HTML_TYPE;
import static io.micronaut.http.MediaType.of;

@Controller
public class ExampleController {

    private static final MediaType IMAGE_SVG_TYPE = of("image/svg+xml");

    @Get
    public StreamedFile getIndex() {
        return new StreamedFile(ExampleController.class.getResourceAsStream("index.html"), TEXT_HTML_TYPE);
    }

    @Get("/{file}")
    public StreamedFile getImage(String file) {
        return new StreamedFile(ExampleController.class.getResourceAsStream(file), IMAGE_SVG_TYPE);
    }

}
