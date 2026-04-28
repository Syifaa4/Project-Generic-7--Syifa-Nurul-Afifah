public class Mahasiswa<T, U, V> {

    // Encapsulation (private)
    private T nim;
    private U name;
    private V clas;

    // Setter
    public void setNim(T nim) {
        this.nim = nim;
    }

    public void setName(U name) {
        this.name = name;
    }

    public void setClas(V clas) {
        this.clas = clas;
    }

    // Getter
    public T getNim() {
        return nim;
    }

    public U getName() {
        return name;
    }

    public V getClas() {
        return clas;
    }
}