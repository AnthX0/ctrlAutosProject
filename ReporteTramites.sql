select 
p.nombre_completo, 
t.DTYPE, 
if(t.fecha_expedicion is null, if(t.fecha_recepcion is null, t.fecha_emision, t.fecha_recepcion), t.fecha_expedicion) as fecha, 
t.costo
from tramites as t
inner join personas as p on t.id_persona = p.id
order by fecha desc;