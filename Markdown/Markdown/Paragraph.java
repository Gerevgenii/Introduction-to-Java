package org.example;

import java.util.List;

public class Paragraph{
    private final List<Markdown> list;

    public Paragraph(List<Markdown> list) {
        this.list = list;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        for (Markdown markdown : list) {
            markdown.toMarkdown(stringBuilder);
        }
    }
}
