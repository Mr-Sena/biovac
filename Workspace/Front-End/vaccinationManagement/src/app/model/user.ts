import { Vacina } from "./Vacina"


export class User {
    public id: number
    public nome: string
    public email: string
    public cpf: string
    public birthday: string
    public vacinacao: Vacina[]
}