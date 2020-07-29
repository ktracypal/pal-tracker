package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;

public class InMemoryTimeEntryRepository extends TimeEntryRepository {
    Map<Long,TimeEntry> memory = new HashMap<>();
    private long id = 1L;

    @Override
    public TimeEntry create(TimeEntry input) {
        long newId = id++;
        TimeEntry newTimeEntry = new TimeEntry(newId, input.getProjectId(),input.getUserId(),input.getDate(),input.getHours());
        memory.put(newId, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return memory.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry expected) {
        TimeEntry newTimeEntry = new TimeEntry(timeEntryId, expected.getProjectId(),expected.getUserId(),expected.getDate(),expected.getHours());
        memory.replace(timeEntryId,newTimeEntry);
        return memory.get(timeEntryId);
    }

    @Override
    public void delete(long timeEntryId) {
        memory.remove(timeEntryId);
    }
}
