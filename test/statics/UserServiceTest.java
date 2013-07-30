package statics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private LocalCache mockLocalCache;
    private Database mockDatabase;

    @Before
    public void setUp() throws Exception {
        mockLocalCache = mock(LocalCache.class);
        mockDatabase = mock(Database.class);
    }

    @Test
    public void should_get_user_from_database() throws Exception {
        // arrange
        UserService userService = new UserService(mockDatabase, mockLocalCache);
        User expectedUser = new User(1, "testUser");

        when(mockLocalCache.get(1)).thenReturn(null);
        when(mockDatabase.find(1)).thenReturn(expectedUser);

        // act
        User user = userService.getUser(1);

        // assert
        assertThat(user, is(expectedUser));
        verify(mockDatabase).find(1);
        verify(mockLocalCache).get(1);
    }

    @Test
    public void should_get_user_from_cache_if_it_has_already_been_fetched() throws Exception {
        // arrange
        UserService userService = new UserService(mockDatabase, mockLocalCache);
        User expectedUser = new User(1, "testUser");

        when(mockLocalCache.get(1)).thenReturn(expectedUser);

        // act
        User user = userService.getUser(1);

        // assert
        assertThat(user, is(expectedUser));
        verify(mockDatabase, never()).find(1);
        verify(mockLocalCache).get(1);
    }

    @Test(expected = NotFoundException.class)
    public void should_raise_not_found_error_if_user_not_in_database() throws Exception {
        // arrange
        UserService userService = new UserService(mockDatabase, mockLocalCache);
        User expectedUser = new User(1, "testUser");

        when(mockLocalCache.get(1)).thenReturn(null);
        when(mockDatabase.find(1)).thenReturn(null);

        // act
        User user = userService.getUser(1);
    }
}
