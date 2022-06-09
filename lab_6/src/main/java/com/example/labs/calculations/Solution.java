package com.example.labs.calculations;

import com.example.labs.SpringConfig;
import com.example.labs.cache.Cache;
import com.example.labs.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Solution {
    private final Cache cache;

    private final Parametres parametres;

    private Integer root;

    public Solution(Parametres params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
        context.close();

        this.parametres = params;
    }

    interface Result{
        int countRes(int n);
    }
    public void calculateRoot() {

        Result Res = (n)->{
            var temp = cache.find(parametres);
            if (temp!=null) {
                ProgramLogger.log(Level.WARN, "Value found in cache!");


                return temp;
            }
            if (parametres.getOperationValue()==0) {

                n = parametres.getAValue() * parametres.getBValue();
            }
            else if(parametres.getOperationValue()==1){
                n = parametres.getAValue() + parametres.getBValue();
            }
            return n;
        };

        setRoot(Res.countRes(0));
        cache.add(parametres, root);
    }

    public Integer getRoot() {
        return root;
    }

    public void  setRoot(@Nullable Integer root) {
        this.root = root;
    }
}
