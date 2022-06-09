package com.example.labs.calculations;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Parametres {
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Parametres params = (Parametres) obj;

        return Objects.equals(a, params.a) &&
                Objects.equals(b, params.b) &&
                Objects.equals(operation, params.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, operation);
    }

    private @Nullable Integer a;
    private @Nullable Integer b;
    private @Nullable Integer operation;

    public Parametres(@Nullable Integer a, @Nullable Integer b, @Nullable Integer operation) {
        if (a == null && b == null && operation == null)
            throw new IllegalArgumentException("No A, B and operation value!");
        if (a == null)
            throw new IllegalArgumentException("No A value!");
        if (b == null)
            throw new IllegalArgumentException("No B value!");
        if (operation == null)
            throw new IllegalArgumentException("No operation value!");

        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getAValue() {
        assert a != null;
        return a;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getBValue() {
        assert b != null;
        return b;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getOperationValue() {
        assert operation != null;
        return operation;
    }

    public void setA(@Nullable Integer A) {
        this.a = A;
    }

    public void setB(@Nullable Integer B) {
        this.b = B;
    }

    public void setOperation(@Nullable Integer operation) {
        this.operation = operation;
    }
}
