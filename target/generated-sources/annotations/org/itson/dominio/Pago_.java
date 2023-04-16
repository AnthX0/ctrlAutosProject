package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-16T16:05:01", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> descripcion;
    public static volatile SingularAttribute<Pago, Persona> persona;
    public static volatile ListAttribute<Pago, Tramite> tramites;
    public static volatile SingularAttribute<Pago, Integer> costoTotal;
    public static volatile SingularAttribute<Pago, String> tipoPago;
    public static volatile SingularAttribute<Pago, Long> id;
    public static volatile SingularAttribute<Pago, Calendar> fechaPago;

}