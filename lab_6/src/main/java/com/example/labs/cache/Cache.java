package com.example.labs.cache;

import com.example.labs.calculations.Parametres;
import com.example.labs.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static final Map<Parametres, Integer> solutions = new HashMap<>();

    public void add(@NotNull Parametres params, @NotNull Integer root) {
        if (!solutions.containsKey(params)) {
            solutions.put(params, root);
            ProgramLogger.log(Level.INFO, "Value " + params + "@" + root + " added to cache!");
        }
    }

    public  @Nullable Integer find(@NotNull Parametres params) {
        if (solutions.containsKey(params))
            return solutions.get(params);

        ProgramLogger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

    @Contract(pure = true)
    public @NotNull String getStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public static @NotNull String getStaticStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public Map<Parametres, Integer> getSolutions() {
        return solutions;
    }
}
