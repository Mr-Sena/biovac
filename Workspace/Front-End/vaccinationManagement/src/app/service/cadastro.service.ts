import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { Vacina } from '../model/Vacina';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  constructor(
    private http: HttpClient
  ) { }

  user(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/cadastro/user', user)

  }

  vacinada(vacina: Vacina): Observable<Vacina> {
    return this.http.post<Vacina>('http://localhost:8080/cadastro/apply-vac', vacina)

  }
}
