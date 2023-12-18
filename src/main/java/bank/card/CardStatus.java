package bank.card;

public enum CardStatus {
    ACTIVE("ACTIVE");

    private final String status;

    CardStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
