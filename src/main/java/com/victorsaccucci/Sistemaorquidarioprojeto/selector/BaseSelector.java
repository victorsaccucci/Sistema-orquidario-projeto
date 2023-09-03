package com.victorsaccucci.Sistemaorquidarioprojeto.selector;

public abstract class BaseSelector {
    private int page;
    private int limit;

    public BaseSelector(){
        this.page = 0;
        this.limit = 0;
    }
    public boolean havePage() {
        return this.limit > 0 && this.page > 0;
    }

    public int getOffset() {
        return this.limit * (this.page - 1);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
