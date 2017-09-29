import { Component, OnInit } from '@angular/core';

import { TaskService } from '../../providers/task.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public taskService: TaskService) { }

  ngOnInit() {
  }

  filterStatus(status) {
    if(status == "ALL") {
      this.taskService.readAll().subscribe(
        data => {
          this.taskService.taskUpdatedEvent.emit(data);
        }
      );
    } else {
      this.taskService.readByStatus(status).subscribe(
        data => {
          this.taskService.taskUpdatedEvent.emit(data);
        }
      );
    }
  }

}
