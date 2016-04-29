DROP TABLE contact;
DROP TABLE resume;

CREATE TABLE resume (
  uuid      VARCHAR(36) PRIMARY KEY,
  full_name VARCHAR(256) NOT NULL,
  about     VARCHAR(512)
);

CREATE TABLE contact (
  id          INTEGER GENERATED AS IDENTITY,
  resume_uuid VARCHAR(36)  NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
  type        VARCHAR(128) NOT NULL,
  value       VARCHAR(128) NOT NULL
);
CREATE UNIQUE INDEX contact_idx ON contact (resume_uuid, type);
