import java.util.*;

    class Item {
        String name;
        double unitprice;

        Item(String name, double unitprice) {
            this.name = name;
            this.unitprice = unitprice;
        }
    }

    class Perishable extends Item {
        Perishable(String name, double unitprice) {
            super(name, unitprice);
        }
    }

    class NonPerishable extends Item {
        double vliters;

        NonPerishable(String name, double unitprice, double vliters) {
            super(name, unitprice);
            this.vliters = vliters;
        }
    }

    class Cart {
        List<Item> items = new ArrayList<>();

        void addPerishable(Perishable item, double kgweight) {
            items.add(item);
            System.out.println(item.name + " " + kgweight + " " + item.unitprice * kgweight);
        }

        void addNonPerishable(NonPerishable item, double quantity) {
            items.add(item);
            System.out.println(item.name + " " + quantity + " " + item.unitprice * quantity);
        }

        List<Item> getItems() {
            return items;
        }
    }

    class Biller {
        private Cart cart;
        private Packer packer;

        Biller(Cart cart, Packer packer) {
            this.cart = cart;
            this.packer = packer;
        }

        double totalcostcalc() {
            double totalcost = 0;
            for (Item item : cart.items) {
                if (item instanceof Perishable) {
                    totalcost += ((Perishable) item).unitprice * packer.getperishableweight((Perishable) item);
                } else if (item instanceof NonPerishable) {
                    totalcost += ((NonPerishable) item).unitprice * packer.getnpq((NonPerishable) item);
                }
            }
            return totalcost;
        }
    }

    class Packer {
        private Map<Perishable, Double> perishableweights = new HashMap<>();
        private Map<NonPerishable, Double> nonperishablequantities = new HashMap<>();
        private double shippingCost = 0.0;

        void setperishableweight(Perishable item, double kgweight) {
            perishableweights.put(item, perishableweights.getOrDefault(item, 0.0) + kgweight);
        }

        void setnpq(NonPerishable item, double quantity) {
            nonperishablequantities.put(item, nonperishablequantities.getOrDefault(item, 0.0) + quantity);
        }

        double getperishableweight(Perishable item) {
            return perishableweights.getOrDefault(item, 0.0);
        }

        double getnpq(NonPerishable item) {
            return nonperishablequantities.getOrDefault(item, 0.0);
        }

        void shippingcostcalc() {
            shippingCost=8.50;
        }

        double getshippingcost() {
            return shippingCost;
        }
    }

    public class javaapplication {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here
            Perishable banana = new Perishable("Banana", 35);
            Perishable carrots = new Perishable("Carrots", 60);
            Perishable potato = new Perishable("Potato", 70);
            Perishable grapes = new Perishable("Grapes", 120);
            NonPerishable butter = new NonPerishable("Butter", 210, 0.2);
            NonPerishable detergent = new NonPerishable("Detergent", 200, 2);
            NonPerishable soap = new NonPerishable("Soap", 35, 0.1);
            NonPerishable notebook = new NonPerishable("Notebook", 40, 0.2);

            Cart cart = new Cart();

            cart.addPerishable(grapes, 0.5);
            cart.addPerishable(potato, 3);
            cart.addNonPerishable(detergent, 2);
            cart.addNonPerishable(soap, 5);
            cart.addNonPerishable(butter, 0.5);
            cart.addPerishable(carrots, 1.5);

            Packer packer = new Packer();
            packer.setperishableweight(grapes, 0.5);
            packer.setperishableweight(potato, 3);
            packer.setnpq(detergent, 2);
            packer.setnpq(soap, 5);
            packer.setnpq(butter, 0.5);
            packer.setperishableweight(carrots, 1.5);

            packer.shippingcostcalc();

            Biller biller = new Biller(cart, packer);

            double totalcost = biller.totalcostcalc();
            double shippingCost = packer.getshippingcost();
            double grandTotal = totalcost + shippingCost;

            System.out.println("Shipping " + String.format("%.2f", shippingCost));
            System.out.println("Total " + String.format("%.2f", grandTotal));
        }
    }

