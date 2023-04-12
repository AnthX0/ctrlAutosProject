#Vehiculo y su dueño
select v.id, p.nombre_completo, v.numero_serie, v.marca, v.linea, v.modelo, v.color from tramites as t
inner join vehiculos as v on t.id_vehiculo = v.id
inner join personas as p on t.id_persona = p.id
group by v.numero_serie;

#Tramites
select t.id, p.nombre_completo, t.DTYPE, t.fecha_expedicion, t.años_vigencia, t.fecha_emision, t.fecha_recepcion from tramites as t
inner join personas as p on t.id_persona = p.id;

#Licencias
select t.id, p.nombre_completo, t.DTYPE, t.fecha_expedicion, t.años_vigencia, t.costo from tramites as t
inner join personas as p on t.id_persona = p.id
where t.DTYPE like 'Licencia';

#Placas
select t.id, p.nombre_completo, t.DTYPE, t.fecha_emision, t.fecha_recepcion, t.identificador from tramites as t
inner join personas as p on t.id_persona = p.id
where t.DTYPE like 'Placa';

#Personas que han hecho tramites
select p.* from tramites as t
inner join personas as p on t.id_persona = p.id
group by t.id_persona;

#Filtros personas que han hecho tramites
select p.* from tramites as t
inner join personas as p on t.id_persona = p.id
where curp like '%ro%' and nombre_completo like '%%' #and fecha_nacimiento >= '2002-04-30'
group by p.id;

#Historial
select t.id, p.nombre_completo, t.DTYPE, if(t.fecha_expedicion is null, if(t.fecha_recepcion is null, t.fecha_emision, t.fecha_recepcion), t.fecha_expedicion) as fecha, t.costo from tramites as t
inner join personas as p on t.id_persona = p.id
where p.nombre_completo like '%judith%'
order by fecha desc;

#Reportes de los trámites realizados por las personas
select 
p.nombre_completo, 
t.DTYPE, 
if(t.fecha_expedicion is null, if(t.fecha_recepcion is null, t.fecha_emision, t.fecha_recepcion), t.fecha_expedicion) as fecha, 
t.costo
from tramites as t
inner join personas as p on t.id_persona = p.id
order by fecha desc;
