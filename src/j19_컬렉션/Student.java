package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor //기본 생성자
//@RequiredArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString

@AllArgsConstructor //전체 생성
@Data // getter setter EqualsAndHashCode ToString을 포함
public class Student {
	
	private String name;
	private int year; //학년
//	private final String address;
	
}
