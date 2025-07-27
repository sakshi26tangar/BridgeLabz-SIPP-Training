public interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, NON_FICTION, SCIENCE;

    @Override
    public String getCategoryName() {
        return "Book - " + this.name();
    }
}

enum ClothingCategory implements Category {
    MENS, WOMENS, KIDS;

    @Override
    public String getCategoryName() {
        return "Clothing - " + this.name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    @Override
    public String getCategoryName() {
        return "Gadget - " + this.name();
    }
}
