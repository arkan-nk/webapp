package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.*;
import ru.javawebinar.webapp.util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * GKislin
 * 30.01.2015.
 */
public class XmlFileStorage extends AbstractFileStorage {
    private XmlParser xmlParser;

    public XmlFileStorage(String dir) {
        super(dir);
        xmlParser = new XmlParser(
                Resume.class, Organization.class, Link.class,
                OrganizationSection.class, TextSection.class, ListSection.class, Organization.Position.class);
    }

    @Override
    public void write(Resume r, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, w);
        }
    }

    @Override
    public Resume read(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }
}
