import { Component, OnInit } from '@angular/core';

import { TaskService } from '../../providers/task.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  data = { task: { id: "", title: "", description: "", status: "" } };
  statuses = [
    {'key': '', 'value': 'Select'},
    {'key': 'COMPLETED', 'value': 'Completed'},
    {'key': 'INPROGRESS', 'value': 'Inprogress'},
    {'key': 'PENDING', 'value': 'Pending'},
    {'key': 'ONHOLD', 'value': 'On Hold'}
  ];

  constructor(public taskService: TaskService) {
  }

  ngOnInit() {
    
  }

  save(data) {
    if(data.status != "") {
      this.taskService.create(data.title, data.description, data.status).subscribe(
        data => {
          this.taskService.taskUpdatedEvent.emit(data);
          this.data = { task: { id: "", title: "", description: "", status: "" } };
        }
      );
    }
  }

}
