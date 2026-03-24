#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

void moveLastToFront(struct Node **head){

    struct Node *temp=*head,*prev=NULL;

    if(*head==NULL || (*head)->next==NULL)
        return;

    while(temp->next!=NULL){
        prev=temp;
        temp=temp->next;
    }

    prev->next=NULL;
    temp->next=*head;
    *head=temp;
}

void display(struct Node *head){

    while(head!=NULL){
        printf("%d -> ",head->data);
        head=head->next;
    }
    printf("NULL\n");
}

int main(){

    struct Node *head=NULL,*temp=NULL,*newNode;
    int data,choice;

    do{
        newNode=(struct Node*)malloc(sizeof(struct Node));

        printf("Enter number: ");
        scanf("%d",&data);

        newNode->data=data;
        newNode->next=NULL;

        if(head==NULL)
            head=temp=newNode;
        else{
            temp->next=newNode;
            temp=newNode;
        }

        printf("Add another node? (1=Yes 0=Exit): ");
        scanf("%d",&choice);

    }while(choice==1);

    printf("Original List:\n");
    display(head);

    moveLastToFront(&head);

    printf("After Moving Last Node to Front:\n");
    display(head);
}