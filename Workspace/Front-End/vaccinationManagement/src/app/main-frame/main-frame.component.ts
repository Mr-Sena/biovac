import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { CadastroService } from '../service/cadastro.service';

@Component({
  selector: 'app-main-frame',
  templateUrl: './main-frame.component.html',
  styleUrls: ['./main-frame.component.css']
})
export class MainFrameComponent implements OnInit {

  usuario: User = new User
  usuarioNull: User = new User

  constructor(
    private cadastramento: CadastroService
    ) { }

  
  ngOnInit() {
    window.scroll(0 ,0)
  }

  cadastrar() {
    this.cadastramento.user(this.usuario).subscribe((resp: User) => {
      this.usuario = resp
      this.usuario = this.usuarioNull
      alert('Usuário cadastrado com sucesso.')
    })

  }

}
