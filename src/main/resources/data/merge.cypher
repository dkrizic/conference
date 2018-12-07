load csv with headers from "file:/persons.csv" as line fieldterminator ','
	merge (p:Person {id:line.id})
		set p.name = line.name;

load csv with headers from "file:/locations.csv" as line fieldterminator ','
	merge (l:Location {id:line.id})
		set l.name = line.name;

load csv with headers from "file:/rooms.csv" as line fieldterminator ','
	merge (r:Room {id:line.id})
		set r.name = line.name,
		r.location = line.location;

load csv with headers from "file:/slots.csv" as line fieldterminator ','
	merge (s:Slot {id:line.id})
		set s.event = line.event,
 		s.room = line.room,
                s.date = line.date;

load csv with headers from "file:/events.csv" as line fieldterminator ','
	merge (e:Event {id:line.id})
		set e.location = line.location,
 		e.startDate = line.room,
                e.durationDays = line.durationDays;

load csv with headers from "file:/talks.csv" as line fieldterminator ','
	merge (t:Talk {id:line.id})
		set t.persons = split(line.persons,";"),
		t.slots = split(line.slots,";"),
		t.title = line.title;

match (r:Room),(l:Location) where r.location = l.id
	merge (r)-[:IN_LOCATION]->(l);

match (e:Event),(l:Location) where e.location = l.id 
	merge (e)-[:IN_LOCATION]->(l);

match (s:Slot),(e:Event)--(l:Location)--(r:Room) where s.event = e.id and s.room = r.id
	merge (s)-[:ON_EVENT]->(e)
	merge (s)-[:IN_ROOM]->(r);

match (t:Talk),(s:Slot) where s.id in t.slots
	merge (t)-[:IN_SLOT]->(s);

match (t:Talk),(p:Person) where p.id in t.persons
	merge (t)-[:BY_PERSON]->(p);
