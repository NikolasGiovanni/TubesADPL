public class ToppingOriginator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public ToppingMemento saveStateToMemento() {
        return new ToppingMemento(state);
    }

    public void getStateFromMemento(ToppingMemento memento) {
        state = memento.getState();
    }
}
