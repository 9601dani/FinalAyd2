package com.danimo;

import java.util.ArrayList;
import java.util.List;

public class FinalExamen {
    public void Main() {
        ProcessData processData = new ProcessData();
        String input = "part1, part2, part3";
        processData.processData(input);

    }

    public interface processDataInterface {
        void processData(String input);
        void printData(List<String> data);
        void printTotal(List<String> data);
    }

    public class ProcessData  implements processDataInterface {
        @Override
        public void processData(String input) {
            List<String> data = new ArrayList<>();
            String[] parts = input.split(",");
            for (String part : parts) {
                part = part.trim();
                if (part.length() > 0) {
                    if (part.length() > 10) {
                        part = part.substring(0, 10);
                    }
                    if (part.matches("[a-zA-Z]+")) {
                        data.add(part.toUpperCase());
                    }
                }
            }
        }
        @Override
        public void printData(List<String> data) {
            System.out.println("Data processed:");
            for (String item : data) {
                System.out.println("- " + item);
            }
        }
        @Override
        public void printTotal(List<String> data) {
            System.out.println("Total items:");
            for (String item : data) {
                System.out.println("- " + item);
            }
        }
    }

    public interface UserBuilderInterface<T extends UserBuilderInterface<T>> {
        T withName(String name);
        T withEmail(String email);
        T withPhone(String phone);
        T withAddress(String address);
        T withCity(String city);
        T withZip(String zip);
        User build();
    }

    public class ConcreteUserBuilder implements UserBuilderInterface<ConcreteUserBuilder> {
        private String name;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String zip;

        @Override
        public ConcreteUserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public ConcreteUserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public ConcreteUserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        @Override
        public ConcreteUserBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public ConcreteUserBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public ConcreteUserBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public class User {
        private String name;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String zip;

        public User(ConcreteUserBuilder userConcreted) {
            this.name = userConcreted.name;
            this.email = userConcreted.email;
            this.phone = userConcreted.phone;
            this.address = userConcreted.address;
            this.city = userConcreted.city;
            this.zip = userConcreted.zip;
        }

    }

    public interface UserInterface {
        String createUser(String name, String email, String phone,
                          String address, String city, String zip);
    }
    public class UserService implements UserInterface {
        @Override
        public String createUser(String name, String email, String phone,
                                 String address, String city, String zip) {
            // Validation logic mixed with creation
            if (name == null || name.isEmpty()) {
                return "Name cannot be empty";
            }
            if (email == null || !email.contains("@")) {
                return "Invalid email";
            }
            // ... more validations

            return "User created: " + name;
        }
    }

    public class Order {
        private String customerName;
        private List<String> items;
        private double total;

        public Order(String customerName, List<String> items, double total) {
            this.customerName = customerName;
            this.items = items;
            this.total = total;
        }
    }

    public interface OrderInterface {
        void printOrderSummary(Order order);
    }

    public class OrderService implements OrderInterface {
        @Override
        public void printOrderSummary(Order order) {
            ReportGenerator generator = new ReportGenerator();
            generator.printHeader(order.customerName);
            for (String item : order.items) {
                generator.printLineItem(item);
            }
            generator.printTotal(order.total);
        }
    }

    public interface ReportGeneratorInterface {
        void printHeader(String customer);
        void printLineItem(String item);
        void printTotal(double total);
    }

    public class ReportGenerator implements ReportGeneratorInterface {
        @Override
        public void printHeader(String customer) {
            System.out.println("Order for: " + customer);
        }

        @Override
        public void printLineItem(String item) {
            System.out.println(" - Item: " + item);
        }

        @Override
        public void printTotal(double total) {
            System.out.println("Total: $" + total);
        }
    }

    public class FiguraGeometrica{
        private List<Double> dimensions;
        public FiguraGeometrica() {
            this.dimensions = new ArrayList<>();
        }

        public double  calcular(){
            throw new IllegalArgumentException("Unknown shape");
        }
    }

    public class Circulo extends FiguraGeometrica {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcular() {
            return Math.PI * radio * radio;
        }
    }

    public class Rectangulo extends FiguraGeometrica {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcular() {
            return base * altura;
        }
    }

    public class Triangulo extends FiguraGeometrica {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcular() {
            return (base * altura) / 2;
        }
    }
}
