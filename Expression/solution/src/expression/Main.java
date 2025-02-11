package expression;

public final class Main {
    public static void main(String[] args) {
        final int x = Integer.parseInt(args[0]);
        System.out.println(new Add(
                new Subtract(
                        new Power(
                                new Variable("x"),
                                new Const(2)
                        ),
                        new Multiply(
                                new Const(2),
                                new Variable("x")
                        )
                ),
                new Const(1)
                ).evaluate(x)
        );
    }
}
