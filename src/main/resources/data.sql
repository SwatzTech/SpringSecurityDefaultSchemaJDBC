/*INSERT into users(username,password,enabled)
values('user','pass',true);

INSERT into users(username,password,enabled)
values('admin','pass',true);

INSERT INTO authorities(username, authority)
values('user','ROLE_USER');

INSERT INTO authorities(username, authority)
values('admin','ROLE_ADMIN');
*/

-- User user/pass
/*INSERT INTO users (username, password, enabled)
  values ('user',
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
    1);
*/
INSERT INTO users (username, password, enabled)
  values ('user',
    'pass',
    1);
    
    INSERT INTO users (username, password, enabled)
  values ('admin',
    'pass',
    1);
    
INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER');
    
INSERT INTO authorities (username, authority)
  values ('admin', 'ROLE_ADMIN');