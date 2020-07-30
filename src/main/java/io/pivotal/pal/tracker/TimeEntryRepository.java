package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;

import java.sql.Time;
import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry any);

    public TimeEntry find(long timeEntryId);

    public List<TimeEntry> list();

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry);

    public void delete(long timeEntryId);
}
