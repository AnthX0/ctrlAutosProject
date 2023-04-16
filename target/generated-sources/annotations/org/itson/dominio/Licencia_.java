package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-16T16:05:01", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ extends Tramite_ {

    public static volatile SingularAttribute<Licencia, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Licencia, String> tipoLicencia;
    public static volatile SingularAttribute<Licencia, Integer> costo;
    public static volatile SingularAttribute<Licencia, Integer> aniosVigencia;

}