drop table if exists contact cascade;
drop table if exists resume cascade;
CREATE TABLE resume (
  uuid      UUID PRIMARY KEY,
  full_name VARCHAR2(256) NOT NULL,
  about     VARCHAR2(512)
);

CREATE TABLE contact (
  id          IDENTITY PRIMARY KEY,
  resume_uuid UUID NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
  type        VARCHAR2(256)     NOT NULL,
  value       VARCHAR2(512)     NOT NULL
);
CREATE UNIQUE INDEX contact_idx ON contact (resume_uuid, type);