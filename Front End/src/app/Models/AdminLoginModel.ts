import { ExamModel } from './examModel';

export class AdminLoginModel{
    constructor(
        adminId : number,
        adminName : string,
        adminPassword : string,
        exams : Array<ExamModel>
    ){}
}