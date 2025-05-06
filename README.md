# Introduction-to-Java in English

This repository is based on the tasks I solved during the first semester of my studies at CT ITMO.

## Homework 2. [Sum of Numbers](Sum/Sum.java)

1. Implement a class `Sum` that, when run from the command line, will sum the provided integers and print the result to the console.
2. Examples of running the program: <br/>

   
   java Sum 1 2 3<br/>
   **Result:** 6<br/>
   java Sum 1 2 -3<br/>
   **Result:** 0<br/>
   java Sum "1 2 3"<br/>
   **Result:** 6<br/>
   java Sum "1 2" " 3"<br/>
   **Result:** 6<br/>
   java Sum " "<br/>
   **Result:** 0<br/>
3. Arguments may contain:

   * digits;
   * `+` and `-` signs;
   * arbitrary [whitespace characters](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isWhitespace%28char%29).
4. You may assume that `int` is sufficient for input values and intermediate results.
5. Review the documentation for the [`String`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) and [`Integer`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html) classes before starting.
6. Use [`System.err`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err) for debug output so it is ignored by the grading system.

> \[!NOTE]
>
> ### Variant ([Double](Sum/SumDouble.java))
>
> * Input data are 64-bit floating-point numbers.
> * The class must be named `SumDouble`.

## Homework 3. [Reverse](Reverse/Reverse.java)

1. Implement a class `Reverse` that reads integers from [standard input](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in) and writes them to [standard output](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out) in reverse order.
2. Each input line contains zero or more integers separated by spaces; each integer fits into an `int`.
3. Output lines should appear in reverse order compared to input lines; within each line, integers should also be reversed.
4. The input contains at most 10⁶ numbers and lines.
5. Use the [`Scanner`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) class to read numbers.
6. Examples:

| Input                   | Output                  |
| :---------------------- | :---------------------- |
| `1 2`<br/>`3`           | `3`<br/>`2 1`           |
| `3`<br/>`2 1`           | `1 2`<br/>`3`           |
| `1`<br/><br/>`2 -3`     | `-3 2`<br/><br/>`1`     |
| `1     2`<br/>`3     4` | `4     3`<br/>`2     1` |

> \[!NOTE]
>
> ### Variant ([Transpose](Reverse/ReverseTranspose.java))
>
> * Treat the input as a (possibly irregular) matrix and output its transpose.
> * The class must be named `ReverseTranspose`.

## Homework 4. [Word Statistics](WordsSuffix/WordStatInput.java)

1. Implement a class `WordStatInput` that counts word occurrences in an input file.
2. A word is any continuous sequence of letters, apostrophes (`'`), and dashes (Unicode [Punctuation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION) and [Dash](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION)). Convert words to lowercase for counting.
3. The output file should list each distinct word in order of first appearance; each line contains the word and its count.
4. Input and output file names are provided as command-line arguments. File encoding: UTF-8.
5. Examples:

| Input                                                                            | Output                                                                                                                  |
| :------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------- |
| `To be, or not to be, that is the question:`                                     | `to 2`<br/>`be 2`<br/>`or 1`<br/>`not 1`<br/>`that 1`<br/>`is 1`<br/>`the 1`<br/>`question 1`                           |
| `Monday's child is fair of face.`<br/>`Tuesday's child is full of grace.`        | `monday's 1`<br/>`child 2`<br/>`is 2`<br/>`fair 1`<br/>`of 2`<br/>`face 1`<br/>`tuesday's 1`<br/>`full 1`<br/>`grace 1` |
| `Шалтай-Болтай`<br/>`Сидел на стене.`<br/>`Шалтай-Болтай`<br/>`Свалился во сне.` | `шалтай-болтай 2`<br/>`сидел 1`<br/>`на 1`<br/>`стене 1`<br/>`свалился 1`<br/>`во 1`<br/>`сне 1`                        |

> \[!NOTE]
>
> ### Variant ([WordsSuffix](WordsSuffix/WordsSuffix.java))
>
> * The output file should list all distinct 3-character suffixes of words from the input, in lexicographical order. Words shorter than 3 characters are used as-is.
> * The class must be named `WordsSuffix`.

## Homework 5. Custom Scanner

1. Implement your own version of the [`Scanner`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) class using a [`Reader`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html).
2. Use your custom Scanner to solve the “Reverse” assignment.
3. Use your custom Scanner to solve the “Word Statistics” assignment.
4. You must use block reading; the reading logic should be shared.
5. *Advanced.* Tokenization for numbers and words must be shared.
6. Pay attention to error handling and tokens that cross buffer boundaries multiple times.

> \[!WARNING]
> I did not complete this assignment due to high workload, but I implemented it as part of the next homework.

## Homework 6. [Word Statistics++](Wspp/Wspp.java)

1. Implement a class `Wspp` that counts word occurrences in an input file and records positions.
2. Word definition is the same as before; convert to lowercase for counting.
3. The output file should list each distinct word in order of first appearance; each line contains the word, its count, and the sequence positions of each occurrence.
4. Input and output file names are command-line arguments. Encoding: UTF-8.
5. The program must run in linear time relative to the input size.
6. Use the Collections Framework.
7. *Advanced.* Implement and use an `IntList` for compact integer storage.
8. Examples:

| Input                                                                            | Output                                                                                                                                             |
| :------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------- |
| `To be, or not to be, that is the question:`                                     | `to 2 1 5`<br/>`be 2 2 6`<br/>`or 1 3`<br/>`not 1 4`<br/>`that 1 7`<br/>`is 1 8`<br/>`the 1 9`<br/>`question 1 10`                                 |
| `Monday's child is fair of face.`<br/>`Tuesday's child is full of grace.`        | `monday's 1 1`<br/>`child 2 2 8`<br/>`is 2 3 9`<br/>`fair 1 4`<br/>`of 2 5 11`<br/>`face 1 6`<br/>`tuesday's 1 7`<br/>`full 1 10`<br/>`grace 1 12` |
| `Шалтай-Болтай`<br/>`Сидел на стене.`<br/>`Шалтай-Болтай`<br/>`Свалился во сне.` | `шалтай-болтай 2 1 5`<br/>`сидел 1 2`<br/>`на 1 3`<br/>`стене 1 4`<br/>`свалился 1 6`<br/>`во 1 7`<br/>`сне 1 8`                                   |

> \[!NOTE]
>
> ### Variant ([CountPosition](Wspp/WsppCountPosition.java))
>
> * Sort by ascending count, then by first appearance.
> * Use `<line>:<position>` for occurrence locations.
> * The class must be named `WsppCountPosition`.

## Homework 7. [Markup](Markdown/Markdown)

1. Implement classes for text markup: `Paragraph`, `Text`, `Emphasis`, `Strong`, `Strikeout`.
2. Markup classes may nest arbitrarily.
3. Implement `toMarkdown(StringBuilder)`:

   * Text: output as-is.
   * Emphasis: surround with `*`.
   * Strong: surround with `__`.
   * Strikeout: surround with `~`.
4. The code below must compile:

   ```java
   Paragraph paragraph = new Paragraph(List.of(
       new Strong(List.of(
           new Text("1"),
           new Strikeout(List.of(
               new Text("2"),
               new Emphasis(List.of(new Text("3"), new Text("4"))),
               new Text("5")
           )),
           new Text("6")
       ))
   ));
   ```

   `paragraph.toMarkdown(new StringBuilder())` should produce `__1~2*34*5~6__`.
5. Place classes in the `markup` package.

> \[!NOTE]
>
> ### Variant ([Tex](Markdown/TexMod))
>
> * Implement `toTex` for TeX markup:
>
>   * Emphasis: `\emph{…}`
>   * Strong: `\textbf{…}`
>   * Strikeout: `\textst{…}`

## Homework 8. Programming Contest

1. Solve as many problems as possible from the 2019 North-Western Russia Regional Contest.
2. Materials:

   * PCMS: Java North-Western Russia Regional Contest – 2019
   * Problem statements
   * Editorials
3. Problems:

| Problem                  |    Topic    | Difficulty |
| :----------------------- | :---------: | :--------: |
| A. Accurate Movement     |   Formulas  |      5     |
| B. Bad Treap             |    Loops    |     10     |
| C. Cross-Stitch          |    Graphs   |     40     |
| D. Double Palindrome     |    Arrays   |     40     |
| E. Equidistant           |    Trees    |     30     |
| H. High Load Database    |    Arrays   |     20     |
| I. Ideal Pyramid         |    Loops    |     15     |
| J. Just the Last Digit   |   Matrices  |     20     |
| K. King’s Children       |    Arrays   |     40     |
| M. Managing Difficulties | Collections |     10     |

> \[!WARNING]
> I did not complete this assignment due to time constraints.

## Homework 9. [Markdown to HTML](Md2Html/Md2Html.java)

1. Implement a converter from Markdown to HTML.
2. Support:

   1. Paragraphs separated by blank lines.
   2. Inline formatting: emphasis (`*`/`_`), strong (`**`/`__`), strikeout (`--`), code (<code>`</code>).
   3. Headers using `#`.
3. Class `md2html.Md2Html` should accept input and output file paths (UTF-8).
4. You may reuse code from the Markup assignment.
5. Example input/output shown in respective folders.

> \[!NOTE]
>
> ### Variant ([Underline](Md2Html/Md2Html.java))
>
> * Add support for `++underline++`: `<u>underline</u>`

## Homework 10. [m,n,k Game](TicTacToe/Main.java)

1. Implement the m,n,k game (k-in-a-row on an m×n board).
2. Add user input validation and error handling.
3. Simple version: O(n·m·k) per move.
4. *Advanced:* O(k) per move and prevent cheating via Position.
5. *Bonus:* Implement a `Winner` player who always wins.

> \[!NOTE]
>
> ### Variant ([Extra Moves](TicTacToe/Main.java))
>
> * Grant extra moves when 4+ in a row appear.

## Homework 11. [Expressions](Expression/solution/src/expression/)

1. Implement `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` for single-variable `int` expressions.
2. Support `.evaluate(x)` and `.toString()` in full parentheses.
3. *Advanced:* `.toMiniString()` with minimal parentheses and `equals` method.
4. Provide `Main` for `x^2-2x+1` evaluation.

> \[!NOTE]
>
> ### Variant ([Triple](Expression/solution/src/expression/))
>
> * Add support for `TripleExpression` with variables x,y,z.

## Homework 12. [Expression Parsing](Expression/solution/src/expression/)

1. Parse infix expressions with `+,-,*,/, unary -`, variables x,y,z, integers, parentheses.
2. Use recursive-descent parsing in linear time.

> \[!NOTE]
>
> ### Variant ([SetClear](Expression/solution/src/expression/))
>
> * Add `set` and `clear` bit operations.

## Homework 13. [Error Handling](Expression/solution/src/expression/)

1. Add parsing and evaluation error handling.
2. For `1000000*x^5/(x-1)`, show a table with `division by zero` or `overflow` messages.

## Homework 14. Tabulator Generic

1. Implement `GenericTabulator` for modes `i`,`d`,`bi` returning a 3D result array.
2. CLI accepts mode and expression, tabulates for x,y,z in \[-2..2].
3. No unchecked casts or `@SuppressWarnings`.

> \[!WARNING]
> This assignment was not completed as the course ended.


# Introduction-to-Java in Russian
This repository is based on the tasks I solved during the first semester during my studies at CT ITMO.

## Домашнее задание 2. [Сумма чисел](Sum/Sum.java)
1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.
2. Примеры запуска программы: <br/>

  java Sum 1 2 3 <br/>
  **Результат:** 6 <br/>
  java Sum 1 2 -3 <br/>
  **Результат:** 0 <br/>
  java Sum "1 2 3" <br/>
  **Результат:** 6 <br/>
  java Sum "1 2" " 3" <br/>
  **Результат:** 6 <br/>
  java Sum " " <br/>
  **Результат:** 0 <br/>
4. Аргументы могут содержать:
   - цифры;
   - знаки `+` и `-`;
   - произвольные [пробельные символы](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isWhitespace(char)).
5. При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип int.
6. Перед выполнением задания ознакомьтесь с документацией к классам [`String`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) и [`Integer`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html).
7. Для отладочного вывода используйте [`System.err`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err), тогда он будет игнорироваться проверяющей программой.
> [!NOTE]
> ### Модификация ([Double](Sum/SumDouble.java))
> - Входные данные являются 64-битными числами с формате с плавающей точкой
> - Класс должен иметь имя `SumDouble`

## Домашнее задание 3. [Реверс](Reverse/Reverse.java)
1. Разработайте класс `Reverse`, читающий числа из [стандартного ввода](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in) и выводящий их на [стандартный вывод](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out) в обратном порядке.
2. В каждой строке входа содержится некоторое количество целых чисел (возможно ноль). Числа разделены пробелами. Каждое число помещается в тип int.
3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке также должен быть обратным к порядку чисел во входе.
4. Вход содержит не более 10⁶ чисел и строк.
5. Для чтения чисел используйте класс [`Scanner`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html).
6. Примеры работы программы:

| Input                   | Output                  |
| :---------------------- | :---------------------- |
| `1 2`<br/>`3`           | `3`<br/>`2 1`           |
| `3`<br/>`2 1`           | `1 2`<br/>`3`           |
| `1`<br/><br/>`2 -3`     | `-3 2`<br/><br/>`1`     |
| `1     2`<br/>`3     4` | `4     3`<br/>`2     1` |

> [!NOTE]
> ### Модификация ([Transpose](Reverse/ReverseTranspose.java))
> - Рассмотрим входные данные как (не полностью определенную) матрицу, выведите ее в транспонированном виде
> - Класс должен иметь имя `ReverseTranspose`

## Домашнее задание 4. [Статистика слов](WordsSuffix/WordStatInput.java)
1. Разработайте класс `WordStatInput`, подсчитывающий статистику встречаемости слов во входном файле.
2. Словом называется непрерывная последовательность букв, апострофов (`'`) и дефисов (Unicode category [Punctuation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION), [Dash](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION)). Для подсчета статистики слова приводятся к нижнему регистру.
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входном файле.
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.
5. Примеры работы программы:

| Input                                                                            | Output                                                                                                                  |
| :------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------- |
| `To be, or not to be, that is the question:`                                     | `to 2`<br/>`be 2`<br/>`or 1`<br/>`not 1`<br/>`that 1`<br/>`is 1`<br/>`the 1`<br/>`question 1`                           |
| `Monday's child is fair of face.`<br/>`Tuesday's child is full of grace.`        | `monday's 1`<br/>`child 2`<br/>`is 2`<br/>`fair 1`<br/>`of 2`<br/>`face 1`<br/>`tuesday's 1`<br/>`full 1`<br/>`grace 1` |
| `Шалтай-Болтай`<br/>`Сидел на стене.`<br/>`Шалтай-Болтай`<br/>`Свалился во сне.` | `шалтай-болтай 2`<br/>`сидел 1`<br/>`на 1`<br/>`стене 1`<br/>`свалился 1`<br/>`во 1`<br/>`сне 1`                        |

> [!NOTE]
> ### Модификация ([WordsSuffix](WordsSuffix/WordsSuffix.java))
> - Выходной файл должен содержать все различные суффиксы длины 3 слов встречающихся во входном файле, в лексикографическом порядке. Слова длины меньшей 3 используются как есть.
> - Класс должен иметь имя `WordsSuffix`

## Домашнее задание 5. Свой сканер
1. Реализуйте свой аналог класса [`Scanner`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) на основе [`Reader`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html).
2. Примените разработанный Scanner для решения задания «Реверс».
3. Примените разработанный Scanner для решения задания «Статистика слов».
4. Нужно использовать блочное чтение. Код, управляющий чтением, должен быть общим.
5. *Сложный вариант.* Код, выделяющий числа и слова, должен быть общим.
6. Обратите внимание на:
   - Обработку ошибок.
   - На слова/числа, пересекающие границы блоков, особенно — больше одного раза.

> [!Warning]
> Это домашнее задание у меня не сделано, так как была большая загруженность.
> Но в итоге это задание было связано со следующим, так что мне всё-равно пришлось его сделать.

## Домашнее задание 6. [Статистика слов++](Wspp/Wspp.java)
1. Разработайте класс `Wspp`, который будет подсчитывать статистику встречаемости слов во входном файле.
2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category [Punctuation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION), [Dash](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#DASH_PUNCTUATION)). Для подсчета статистики, слова приводятся к нижнему регистру.
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.
5. Программа должна работать за линейное от размера входного файла время.
6. Для реализации программы используйте Collections Framework.
7. *Сложный вариант.* Реализуйте и примените класс `IntList`, компактно хранящий список целых чисел.
8. Примеры работы программы:

| Input                                                                            | Output                                                                                                                                             |
| :------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------- |
| `To be, or not to be, that is the question:`                                     | `to 2 1 5`<br/>`be 2 2 6`<br/>`or 1 3`<br/>`not 1 4`<br/>`that 1 7`<br/>`is 1 8`<br/>`the 1 9`<br/>`question 1 10`                                 |
| `Monday's child is fair of face.`<br/>`Tuesday's child is full of grace.`        | `monday's 1 1`<br/>`child 2 2 8`<br/>`is 2 3 9`<br/>`fair 1 4`<br/>`of 2 5 11`<br/>`face 1 6`<br/>`tuesday's 1 7`<br/>`full 1 10`<br/>`grace 1 12` |
| `Шалтай-Болтай`<br/>`Сидел на стене.`<br/>`Шалтай-Болтай`<br/>`Свалился во сне.` | `шалтай-болтай 2 1 5`<br/>`сидел 1 2`<br/>`на 1 3`<br/>`стене 1 4`<br/>`свалился 1 6`<br/>`во 1 7`<br/>`сне 1 8`                                   |

> [!NOTE]
> ### Модификация ([CountPosition](Wspp/WsppCountPosition.java))
> - В выходном файле слова должны быть упорядочены по возрастанию числа вхождений, а при равном числе вхождений – по порядку первого вхождения во входном файле.
> - Вместо номеров вхождений во всем файле надо указывать `<номер строки>:<номер в строке>`
> - Класс должен иметь имя `WsppCountPosition`

## Домашнее задание 7. [Разметка](Markdown/Markdown)
1. Разработайте набор классов для текстовой разметки.
2. Класс `Paragraph` может содержать произвольное число других элементов разметки и текстовых элементов.
3. Класс `Text` – текстовый элемент.
4. Классы разметки `Emphasis`, `Strong`, `Strikeout` – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.
5. Все классы должны реализовывать метод `toMarkdown`([`StringBuilder`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html)), который должен генерировать [`Markdown`](https://ru.wikipedia.org/wiki/Markdown)-разметку по следующим правилам:
   1. текстовые элементы выводятся как есть;
   2. выделенный текст окружается символами '`*`';
   3. сильно выделенный текст окружается символами '`__`';
   4. зачеркнутый текст окружается символами '`~`'.
6. Следующий код должен успешно компилироваться: <br/>

   ```java
   Paragraph paragraph = new Paragraph(List.of(
       new Strong(List.of(
           new Text("1"),
           new Strikeout(List.of(
               new Text("2"),
               new Emphasis(List.of(new Text("3"), new Text("4"))),
               new Text("5")
           )),
           new Text("6")
       ))
   ));
   ```

   Вызов `paragraph.toMarkdown(new StringBuilder())` должен заполнять переданный `StringBuilder` следующим содержимым: <br/>
   `\_\_1\~2\*34\*5\~6\_\_`
7. Разработанные классы должны находиться в пакете `markup`.

> [!NOTE]
> ### Модификация ([Tex](Markdown/TexMod))
> - Дополнительно реализуйте метод toTex, генерирующий TeX-разметку:
>   - выделеный текст заключается в `\emph{ и }`;
>   - сильно выделеный текст заключается в `\textbf{ и }`;
>   - зачеркнутый текст заключается в `\textst{ и }`.

## Домашнее задание 8. Чемпионат
1. Решите как можно больше задач Чемпионата северо-запада России по программированию 2019.
2. Материалы соревнования:
   - PCMS: Java. North-Western Russia Regional Contest - 2019
   - Условия задач
   - Разбор задач
3. Задачи для решения

   | Задача                   |    Тема     | Сложность  |
   | :----------------------- | :---------: | :--------: |
   | A.	Accurate Movement     |   Формула   |      5     |
   | B.	Bad Treap             |    Циклы    |     10     |
   | C.	Cross-Stitch          |    Графы    |     40     |
   | D.	Double Palindrome     |   Массивы   |     40     |
   | E.	Equidistant           |   Деревья   |     30     |
   | H.	High Load Database    |   Массивы   |     20     |
   | I.	Ideal Pyramid         |    Циклы    |     15     |
   | J.	Just the Last Digit   |   Матрицы   |     20     |
   | K.	King’s Children       |   Массивы   |     40     |
   | M.	Managing Difficulties |  Коллекции  |     10     |
4. Рекомендуемое время выполнения задания: 3 часа

> [!Warning]
> Это домашнее задание у меня не сделано, так как была большая загруженность.

## Домашнее задание 9. [Markdown to HTML](Md2Html/Md2Html.java)
1. Разработайте конвертер из [Markdown](https://ru.wikipedia.org/wiki/Markdown)-разметки в [HTML](https://ru.wikipedia.org/wiki/HTML).
2. Конвертер должен поддерживать следующие возможности:
   1. Абзацы текста разделяются пустыми строками.
   2. Элементы строчной разметки: выделение (`*` или `_`), сильное выделение (`**` или `__`), зачеркивание (`--`), код (<code>`</code>)
   3. Заголовки (# * уровень заголовка)
3. Конвертер должен называться `md2html.Md2Html` и принимать два аргумента: название входного файла с Markdown-разметкой и название выходного файла c HTML-разметкой. Оба файла должны иметь кодировку UTF-8.
4. При выполнении этого ДЗ можно повторно использовать код ДЗ markup.
5. Конвертер может хранить исходные и сконвертированные данные в памяти, в том числе, одновременно.
6. Пример
   - Входной файл
   ```
   # Заголовок первого уровня

   ## Второго

   ### Третьего ## уровня

   #### Четвертого
   # Все еще четвертого

   Этот абзац текста,
   содержит две строки.
   
       # Может показаться, что это заголовок.
   Но нет, это абзац начинающийся с `#`.

   #И это не заголовок.
   
   ###### Заголовки могут быть многострочными
   (и с пропуском заголовков предыдущих уровней)
   
   Мы все любим *выделять* текст _разными_ способами.
   **Сильное выделение**, используется гораздо реже,
   но __почему бы и нет__?
   Немного --зачеркивания-- еще ни кому не вредило.
   Код представляется элементом `code`.
   
   Обратите внимание, как экранируются специальные
   HTML-символы, такие как `<`, `>` и `&`.
   
   Знаете ли вы, что в Markdown, одиночные * и _
   не означают выделение?
   Они так же могут быть заэкранированы
   при помощи обратного слэша: \*.
   
   
   
   Лишние пустые строки должны игнорироваться.
   
   Любите ли вы *вложеные __выделения__* так,
   как __--люблю--__ их я?
   ```
   - Выходной файл
   ```
   <h1>Заголовок первого уровня</h1>
   <h2>Второго</h2>
   <h3>Третьего ## уровня</h3>
   <h4>Четвертого
   # Все еще четвертого</h4>
   <p>Этот абзац текста,
   содержит две строки.</p>
   <p>    # Может показаться, что это заголовок.
   Но нет, это абзац начинающийся с <code>#</code>.</p>
   <p>#И это не заголовок.</p>
   <h6>Заголовки могут быть многострочными
   (и с пропуском заголовков предыдущих уровней)</h6>
   <p>Мы все любим <em>выделять</em> текст <em>разными</em> способами.
   <strong>Сильное выделение</strong>, используется гораздо реже,
   но <strong>почему бы и нет</strong>?
   Немного <s>зачеркивания</s> еще ни кому не вредило.
   Код представляется элементом <code>code</code>.</p>
   <p>Обратите внимание, как экранируются специальные
   HTML-символы, такие как <code>&lt;</code>, <code>&gt;</code> и <code>&amp;</code>.</p>
   <p>Знаете ли вы, что в Markdown, одиночные * и _
   не означают выделение?
   Они так же могут быть заэкранированы
   при помощи обратного слэша: *.</p>
   <p>Лишние пустые строки должны игнорироваться.</p>
   <p>Любите ли вы <em>вложеные <strong>выделения</strong></em> так,
   как <strong><s>люблю</s></strong> их я?</p>
   ```
### [Реальная разметка](https://codesandbox.io/p/sandbox/czpv6s)

> [!NOTE]
> ### Модификация ([Underline](Md2Html/Md2Html.java))
> - Добавьте поддержку `++подчеркивания++`: `<u>подчеркивания</u>`

## Домашнее задание 10. [Игра m,n,k](TicTacToe/Main.java)
В этом домашнем задании вы можете пользоваться кодом, написанным на лекции. Он есть на сайте курса и в репозитории prog-intro-2021-solutions.

1. Реализуйте [игру m,n,k](https://en.wikipedia.org/wiki/M,n,k-game) (k в ряд на доске m×n).
2. Добавьте обработку ошибок ввода пользователя. В случае ошибочного хода пользователь должен иметь возможность сделать другой ход.
3. Добавьте обработку ошибок игроков. В случае ошибки игрок автоматически проигрывает.
4. Простая версия. Доска может производить обработку хода за O(nmk).
5. *Сложная версия.*
   - Доска должна производить обработку хода (проверку корректности, изменение состояния и определение результата) за O(k).
   - Предотвратите жульничество: у игрока не должно быть возможности достать Board из Position.
6. *Бонусная версия.* Реализуйте `Winner` — игрок, который выигрывает всегда, когда это возможно (против любого соперника).

> [!NOTE]
> ### Модификация ([Дополнительные ходы](TicTacToe/Main.java))
> - Если в результате хода игрока на доске появляется новая последовательность из 4+ одинаковых символов, то он делает дополнительный ход.
> - Игрок может сделать несколько дополнительных ходов подряд.

> [!IMPORTANT]
> Следующие задания связаны между собой, поэтому лежат в одном месте

## Домашнее задание 11. [Выражения](Expression/solution/src/expression/)
1. Разработайте классы `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, `Divide` для вычисления выражений с одной переменной в типе `int` (интерфейс Expression).
2. Классы должны позволять составлять выражения вида
   ```
   new Subtract(
       new Multiply(
           new Const(2),
           new Variable("x")
       ),
       new Const(3)
   ).evaluate(5)
   ```         
   При вычислении такого выражения вместо каждой переменной подставляется значение, переданное в качестве параметра методу `evaluate`. Таким образом, результатом вычисления приведенного примера должно стать число 7. <br/>
3. Метод `toString` должен выдавать запись выражения в полноскобочной форме. Например
   ```
   new Subtract(
       new Multiply(
           new Const(2),
           new Variable("x")
       ),
       new Const(3)
   ).toString()
   ```
   должен выдавать ((2 * x) - 3). <br/>
4. Сложный вариант. Метод `toMiniString` (интерфейс ToMiniString) должен выдавать выражение с минимальным числом скобок. Например
   ```
   new Subtract(
       new Multiply(
           new Const(2),
           new Variable("x")
       ),
       new Const(3)
   ).toMiniString()
   ```
   должен выдавать 2 * x - 3.
5. Реализуйте метод `equals`, проверяющий, что два выражения совпадают. Например,
   ```
   new Multiply(new Const(2), new Variable("x"))
       .equals(new Multiply(new Const(2), new Variable("x")))
   ```
      должно выдавать true, а <br/>
   ```
   new Multiply(new Const(2), new Variable("x"))
       .equals(new Multiply(new Variable("x"), new Const(2)))
   ```
   должно выдавать false. <br/>
6. Для тестирования программы должен быть создан класс `Main`, который вычисляет значение выражения `x2−2x+1`, для x, заданного в командной строке.
7. При выполнении задания следует обратить внимание на:
   - Выделение общего интерфейса создаваемых классов.
   - Выделение абстрактного базового класса для бинарных операций.

> [!NOTE]
> ### Модификация ([Triple](Expression/solution/src/expression/))
> - Дополнительно реализуйте поддержку выражений с тремя переменными: x, y и z.
> - Интерфейс `TripleExpression`.

## Домашнее задание 12. [Разбор выражений](Expression/solution/src/expression/)
1. Доработайте предыдущее домашнее задание так, чтобы выражение строилось по записи вида
   x * (x - 2)*x + 1 <br/>
2. В записи выражения могут встречаться:
   - бинарные операции: умножение `*`, деление `/`, сложение `+` и вычитание `-`;
   - унарный минус `-`;
   - переменные `x`, `y` и `z`;
   - целочисленные константы в десятичной системе счисления, помещающиеся в 32-битный знаковый целочисленный тип;
   - круглые скобки для явного обозначения приоритета операций;
   - произвольное число пробельных символов в любом месте, не влияющем на однозначность понимания формулы (например, между операцией и переменной, но не внутри констант).
3. Приоритет операций, начиная с наивысшего
   1.унарный минус;
   2. умножение и деление;
   3. сложение и вычитание.
4. Разбор выражений рекомендуется производить [методом рекурсивного спуска](https://ru.wikibooks.org/wiki/Реализации_алгоритмов/Метод_рекурсивного_спуска).
   - Алгоритм должен работать за линейное время.
   - Лексический анализ (токенизация) не требуется.

> [!NOTE]
> ### Модификация ([SetClear](Expression/solution/src/expression/))
> - Дополнительно реализуйте бинарные операции (минимальный приоритет):
>   - `set` – установка бита, 2 set 3 равно 10;
>   - `clear` – сброс бита, 10 clear 3 равно 2.

## Домашнее задание 13. [Обработка ошибок](Expression/solution/src/expression/)
1. Добавьте в программу, вычисляющую выражения, обработку ошибок, в том числе:
   - ошибки разбора выражений;
   - ошибки вычисления выражений.
2. Для выражения 1000000*x*x*x*x*x/(x-1) вывод программы должен иметь следующий вид:

   |   x   | f                |
   | :---: | :--------------- |
   |   0   | 0                |
   |   1   | division by zero |
   |   2   | 32000000         |
   |   3   | 121500000        |
   |   4   | 341333333        |
   |   5   | overflow         |
   |   6   | overflow         |
   |   7   | overflow         |
   |   8   | overflow         |
   |   9   | overflow         |
   |  10   | overflow         |

   Результат division by zero (overflow) означает, что в процессе вычисления произошло деление на ноль (переполнение). <br/>
3. При выполнении задания следует обратить внимание на дизайн и обработку исключений.
4. Человеко-читаемые сообщения об ошибках должны выводиться на консоль.
5. Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными).

> [!NOTE]
> ### Модификация ([SetClear](Expression/solution/src/expression/))
> - Дополнительно реализуйте бинарные операции (минимальный приоритет):
>   - set – установка бита, 2 set 3 равно 10;
>   - clear – сброс бита, 10 clear 3 равно 2.

## Домашнее задание 14. Вычисление в различных типах
Добавьте в программу разбирающую и вычисляющую выражения трех переменных поддержку вычисления в различных типах.
1. Создайте класс `expression.generic.GenericTabulator`, реализующий интерфейс `expression.generic.Tabulator`:
   ```
    public interface Tabulator {
        Object[][][] tabulate(
            String mode, String expression, 
            int x1, int x2, int y1, int y2, int z1, int z2
        ) throws Exception;
    }
   ```
   Аргументы
   - `mode` — режим работы
   
   | Режим | Тип                                                                                                  |
   | :---: | :--------------------------------------------------------------------------------------------------- |
   |   i   | int с детекцией переполнений                                                                         |
   |   d   | double                                                                                               |
   |   bi  | [BigInteger](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigInteger.html) |
   - `expression` — вычисляемое выражение;
   - x1, x2; y1, y2; z1, z2 — диапазоны изменения переменных (включительно).
   Возвращаемое значение — таблица значений функции, где R[i][j][k] соответствует x = x1 + i, y = y1 + j, z = z1 + k. Если вычисление завершилось ошибкой, в соответствующей ячейке должен быть null.

2. Доработайте интерфейс командной строки:
   - Первым аргументом командной строки программа должна принимать указание на тип, в котором будут производиться вычисления:
   
   | Опция | Тип                                                                                                  |
   | :---: | :--------------------------------------------------------------------------------------------------- |
   |   i   | int с детекцией переполнений                                                                         |
   |   d   | double                                                                                               |
   |   bi  | [BigInteger](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigInteger.html) |
   - Вторым аргументом командной строки программа должна принимать выражение для вычисления.
   - Программа должна выводить результаты вычисления для всех целочисленных значений переменных из диапазона −2..2.
3. Реализация не должна содержать [непроверяемых преобразований типов](https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html#jls-5.1.9).
4. Реализация не должна использовать аннотацию [`@SuppressWarnings`](https://docs.oracle.com/javase/specs/jls/se21/html/jls-9.html#jls-9.6.4.5).
5. При выполнении задания следует обратить внимание на простоту добавления новых типов и операций. <br/><br/>

> [!WARNING]
> Это задание я не делал, так как к тому времени уже закрылся.
