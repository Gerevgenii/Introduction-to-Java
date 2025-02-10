# Introduction-to-Java
This repository is based on the tasks I solved during the first semester during my studies at CT ITMO.

Домашнее задание 2. Сумма чисел
1) Разработайте класс Sum, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.
2) Примеры запуска программы: <br/>
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
4) Аргументы могут содержать:
  - цифры;
  - знаки + и -;
  - произвольные [пробельные символы](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isWhitespace(char)).
5) При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип int.
6) Перед выполнением задания ознакомьтесь с документацией к классам [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html) и [Integer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html).
7) Для отладочного вывода используйте [System.err](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#err), тогда он будет игнорироваться проверяющей программой.
