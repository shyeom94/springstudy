package com.gdu.prj08.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileDto {

  private int file_no;
  private String upload_path;
  private String original_filename;
  private String filesystem_name;
  private int history_no;

}
