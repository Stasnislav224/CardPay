public enum Status {
    InBlocked("in_blocked"),
    Active("active"),
    NoActive("no_active"),
    InTheProcessOfRelease("in_the_process_of_release"),
    Pending("pending"),
    Completed("completed"),
    Failed("failed"),
    Reversed("reversed");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}