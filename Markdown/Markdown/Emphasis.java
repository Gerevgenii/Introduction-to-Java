package org.example;

import java.util.List;

public class Emphasis implements Markdown{

    private final List<Markdown> list;

    public Emphasis(List<Markdown> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append('*');
        for (Markdown markdown : list) {
            markdown.toMarkdown(stringBuilder);
        }
        stringBuilder.append('*');
    }
}
