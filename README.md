# Introduction-to-Java #
This repository is based on the tasks I solved during the first semester during my studies at CT ITMO.

## Домашнее задание 2. Сумма чисел ##
1. Разработайте класс Sum, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.
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
   - знаки + и -;
   - произвольные [пробельные символы](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isWhitespace(char)).
5. При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип int.
6. Перед выполнением задания ознакомьтесь с документацией к классам [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) и [Integer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html).
7. Для отладочного вывода используйте [System.err](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err), тогда он будет игнорироваться проверяющей программой.
> [!NOTE]
> ### Модификация (Double) ###
> - Входные данные являются 64-битными числами с формате с плавающей точкой
> - Класс должен иметь имя SumDouble

## Домашнее задание 3. Реверс ##
1. Разработайте класс Reverse, читающий числа из [стандартного ввода](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#in) и выводящий их на [стандартный вывод](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out) в обратном порядке.
2. В каждой строке входа содержится некоторое количество целых чисел (возможно ноль). Числа разделены пробелами. Каждое число помещается в тип int.
3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке также должен быть обратным к порядку чисел во входе.
4. Вход содержит не более 10⁶ чисел и строк.
5. Для чтения чисел используйте класс [Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html).
6. Примеры работы программы:

| Input | Output |
| :--- | :--- |
| 1 2 <br/> 3 | 3 <br/> 2 1 |
| 3 <br/> 2 1 | 1 2 <br/> 3 |
| 1 <br/><br/> 2 -3 | -3 2 <br/><br/> 1 |
| 1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2 <br/> 3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4 | 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3 <br/> 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 |

> [!NOTE]
> ### Модификация (Transpose) ###
> - Рассмотрим входные данные как (не полностью определенную) матрицу, выведите ее в транспонированном виде
> - Класс должен иметь имя ReverseTranspose

## Домашнее задание 4. Статистика слов ##
1. Разработайте класс WordStatInput, подсчитывающий статистику встречаемости слов во входном файле.
2. Словом называется непрерывная последовательность букв, апострофов (') и дефисов (Unicode category Punctuation, Dash). Для подсчета статистики слова приводятся к нижнему регистру.
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входном файле.
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.
5. Примеры работы программы:

| Input | Output |
| :--- | :--- |
| To be, or not to be, that is the question: | to 2 <br/>be 2 <br/>or 1 <br/>not 1 <br/>that 1 <br/>is 1 <br/>the 1 <br/>question 1 |
| Monday's child is fair of face. <br/>Tuesday's child is full of grace. | monday's 1 <br/>child 2 <br/>is 2 <br/>fair 1 <br/>of 2 <br/>face 1 <br/>tuesday's 1 <br/>full 1 <br/>grace 1 |
| Шалтай-Болтай <br/>Сидел на стене. <br/>Шалтай-Болтай <br/>Свалился во сне. | шалтай-болтай 2 <br/>сидел 1 <br/>на 1 <br/>стене 1 <br/>свалился 1 <br/>во 1 <br/>сне 1 |

> [!NOTE]
> ### Модификация (WordsSuffix) ###
> - Выходной файл должен содержать все различные суффиксы длины 3 слов встречающихся во входном файле, в лексикографическом порядке. Слова длины меньшей 3 используются как есть.
> - Класс должен иметь имя WordStatWordsSuffix


