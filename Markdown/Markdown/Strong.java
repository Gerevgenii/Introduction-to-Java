package org.example;

import java.util.List;

public class Strong implements Markdown{

    private final List<Markdown> list;

    public Strong(List<Markdown> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("__");
        for (Markdown markdown : list) {
            markdown.toMarkdown(stringBuilder);
        }
        stringBuilder.append("__");
    }
}
