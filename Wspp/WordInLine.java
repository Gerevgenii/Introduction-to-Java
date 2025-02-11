package wspp;

record WordInLine(String string, Position position){
    @Override
    public String toString() {
        return string + ' ' + position;
    }
}
