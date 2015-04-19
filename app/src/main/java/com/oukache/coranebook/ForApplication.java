package com.oukache.coranebook;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

/**
 * Created by Oukache on 18/04/2015.
 */

@Qualifier @Retention(RUNTIME)
public @interface ForApplication {
}