package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;


/*
회원 목록 조회: GET /users
회원 등록: POST /users
회원 조회: GET /users/{userId}
회원 수정: PATCH /users/{userId}
회원 삭제: DELETE /users/{userId}
*/

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

     
    // GET /mapping/users
    // http://localhost:8080/mapping/users
    @GetMapping
    public String users() {
        return "get users";
    }

    // POST /mapping/users
    // http://localhost:8080/mapping/users
    @PostMapping
    public String addUser() {
        return "post user";
    }

    // GET /mapping/users/{userId}
    // http://localhost:8080/mapping/users/1
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    // PATCH /mapping/users/{userId}
    // http://localhost:8080/mapping/users/1
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    // DELETE /mapping/users/{userId}
    // http://localhost:8080/mapping/users/1
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }
}
